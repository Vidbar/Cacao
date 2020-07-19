package packages.cacao.listeners

import packages.cacao.geometry.Offset

interface IHitTestable {
    fun hitTest(result: HitTestResult, position: Offset)
}