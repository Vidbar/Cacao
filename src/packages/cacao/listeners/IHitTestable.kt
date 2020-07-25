package packages.cacao.listeners

import packages.cacao.geometry.Point

interface IHitTestable {
    fun hitTest(result: HitTestResult, position: Point)
}