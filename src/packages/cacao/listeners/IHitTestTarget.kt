package packages.cacao.listeners

import packages.cacao.events.Event

interface IHitTestTarget {
    fun handleEvent(event: Event)
}