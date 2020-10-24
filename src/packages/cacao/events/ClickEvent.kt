package packages.cacao.events

import packages.cacao.geometry.Point

public class ClickEvent(
        public val position: Point
) : Event()
