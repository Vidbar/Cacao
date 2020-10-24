package packages.cacao

import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import packages.cacao.Updater.Companion.updater
import packages.cacao.elements.renderElements.RenderElement
import packages.cacao.elements.renderElements.SingleChildRenderElement
import packages.cacao.geometry.Size
import packages.cacao.graphic.adapter.AwtAdapter
import packages.cacao.graphic.adapter.EmptyGraphicAdapter
import packages.cacao.graphic.paintRenderObject
import packages.cacao.graphic.setGraphicAdapter
import packages.cacao.listeners.GlobalMouseListener
import packages.cacao.renderObjects.ViewRenderObject
import packages.cacao.widgets.Widget
import packages.cacao.widgets.renderWidgets.View
import java.util.logging.Level
import java.util.logging.Logger

public fun run(app: Widget) {
    Cacao.instance.attachRootWidget(app)
}

private var headless = false

public fun startHeadlessMode() {
    headless = true
}

public fun endHeadlessMode() {
    headless = false
}

public class Cacao private constructor() {
    public companion object {
        public val instance: Cacao = Cacao()
    }

    private val buildOwner: BuildOwner = BuildOwner()
    public lateinit var rootElement: RenderElement

    init {
        if (headless) {
            setGraphicAdapter(EmptyGraphicAdapter())
        } else {
            setGraphicAdapter(AwtAdapter(Size(600.0, 375.0)))
            // setGraphicAdapter(SwingAdapter(Size(600.0, 375.0)))
            // this.initializeHooks()

            updater.setDrawUpdate { drawFrame() }
        }
    }

    private fun initializeHooks(viewRenderObject: ViewRenderObject) {
        if (headless) return

        try {
            GlobalScreen.registerNativeHook()
            val logger: Logger = Logger.getLogger(GlobalScreen::class.java.getPackage().name)
            logger.level = Level.WARNING
        } catch (ex: NativeHookException) {
            throw Error("Registering hooks fail")
        }

        GlobalScreen.addNativeMouseListener(GlobalMouseListener(viewRenderObject))
    }

    public fun attachRootWidget(app: Widget) {
        val view = this.createView(app)
        this.initializeHooks(view.createRenderObject())

        this.rootElement = view.createElement()
        this.rootElement.assignOwner(this.buildOwner)
        (this.rootElement as SingleChildRenderElement).mount(null)

        updater.enqueueUpdate()
        updater.resolveUpdates()
    }

    private fun createView(app: Widget): View {
        return if (app is View) {
            app
        } else {
            // RenderView with a default value in case the user doesn't provide any.
            View(Size(600.0, 375.0), app)
        }
    }

    private fun layout() {
        if (!this::rootElement.isInitialized)
            throw Error("rootElement must be initialized before perform layout.")

        this.rootElement.renderObject?.performLayout()
    }

    private fun render() {
        if (!this::rootElement.isInitialized)
            throw Error("rootElement must be initialized before perform render.")

        this.rootElement.renderObject?.let { paintRenderObject(it) }
    }

    private fun drawFrame() {
        this.buildOwner.buildScope()
        this.layout()
        this.render()
    }
}
