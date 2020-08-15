package packages.cacao.events

import packages.cacao.geometry.Point

class ClickEvent(
    val position: Point
) : Event()