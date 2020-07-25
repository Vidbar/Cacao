package packages.cacao

import org.jnativehook.GlobalScreen
import org.jnativehook.NativeHookException
import packages.cacao.elements.Element
import packages.cacao.elements.RenderElement
import packages.cacao.geometry.Size
import packages.cacao.graphic.initGraphicAdapter
import packages.cacao.graphic.repaintCompositeChild
import packages.cacao.listeners.MouseListener
import packages.cacao.renderObjects.RenderView
import packages.cacao.widgets.RootWidget
import packages.cacao.widgets.Widget
import java.util.logging.Level
import java.util.logging.Logger

fun run(app: Widget) {
    Cacao.instance.attachRootWidget(app)
    Cacao.instance.layout()
    Cacao.instance.render()
}

class Cacao private constructor() {
    companion object {
        val instance = Cacao()
    }

    // RenderView with a default value in case the user doesn't provide any.
    private val renderView = RenderView(Size(600.0, 375.0))
    lateinit var rootElement: RenderElement

    init {
        this.initializeGraphics()
        this.initializeHooks()
    }

    private fun initializeGraphics() {
        initGraphicAdapter(Size(600.0, 375.0))
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
        this.rootElement.mount(null)
    }

    fun layout() {
        if (!this::rootElement.isInitialized)
            throw Error("rootElement must be initialized before perform layout.")

        this.rootElement.renderObject?.performLayout()
    }

    fun render() {
        if (!this::rootElement.isInitialized)
            throw Error("rootElement must be initialized before perform render.")

        this.rootElement.renderObject?.let { repaintCompositeChild(it) }
    }
}

