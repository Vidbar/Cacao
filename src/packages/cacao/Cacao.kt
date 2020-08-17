package packages.cacao

import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import packages.cacao.Updater.Companion.updater
import packages.cacao.elements.RenderElement
import packages.cacao.geometry.Size
import packages.cacao.graphic.adapter.AwtAdapter
import packages.cacao.graphic.adapter.EmptyGraphicAdapter
import packages.cacao.graphic.paintRenderObject
import packages.cacao.graphic.setGraphicAdapter
import packages.cacao.listeners.MouseListener
import packages.cacao.renderObjects.RenderView
import packages.cacao.widgets.RootWidget
import packages.cacao.widgets.Widget
import java.util.logging.Level
import java.util.logging.Logger

fun run(app: Widget) {
    Cacao.instance.attachRootWidget(app)
}

private var headless = false

fun startHeadlessMode() {
    headless = true
}

fun endHeadlessMode() {
    headless = false
}

class Cacao private constructor() {
    companion object {
        val instance = Cacao()
    }

    // RenderView with a default value in case the user doesn't provide any.
    private val renderView = RenderView(Size(600.0, 375.0))
    private val buildOwner: BuildOwner = BuildOwner()
    lateinit var rootElement: RenderElement

    init {
        if (headless) {
            setGraphicAdapter(EmptyGraphicAdapter())
        } else {
            setGraphicAdapter(AwtAdapter(Size(600.0, 375.0)))
            // setGraphicAdapter(SwingAdapter(Size(600.0, 375.0)))
            this.initializeHooks()

            updater.setDrawUpdate { drawFrame() }
        }
    }

    private fun initializeHooks() {
        try {
            GlobalScreen.registerNativeHook()
            val logger: Logger = Logger.getLogger(GlobalScreen::class.java.getPackage().name)
            logger.level = Level.WARNING
        } catch (ex: NativeHookException) {
            throw Error("Registering hooks fail")
        }

        GlobalScreen.addNativeMouseListener(MouseListener(this.renderView))
    }

    fun attachRootWidget(app: Widget) {
        val rootWidget = RootWidget(this.renderView, app)
        this.rootElement = rootWidget.createElement()
        this.rootElement.assignOwner(this.buildOwner)
        this.rootElement.mount(null)

        updater.enqueueUpdate()
        updater.resolveUpdates()
    }

    fun layout() {
        if (!this::rootElement.isInitialized)
            throw Error("rootElement must be initialized before perform layout.")

        this.rootElement.renderObject?.performLayout()
    }

    fun render() {
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
