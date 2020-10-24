package packages.cacao.listeners

import packages.cacao.events.Event

public interface IHitTestTarget {
    public fun handleEvent(event: Event)
}
