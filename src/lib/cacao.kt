package lib

import lib.widgets.Widget

val environment = Environment()
fun runApp(app: Widget) {
    environment.attachRootWidget(app)
    environment.render()
}