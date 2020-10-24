package packages.cacao.listeners

import packages.cacao.geometry.Point

public interface IHitTestable {
    public fun hitTest(result: HitTestResult, position: Point)
}
