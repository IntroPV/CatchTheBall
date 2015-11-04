package ar.pablitar.catchtheball

object Test {
  val bounds = RectangularBounds((0.0, 0.0), (800.0, 600.0))
                                                  //> bounds  : ar.pablitar.catchtheball.RectangularBounds = RectangularBounds((0.
                                                  //| 0, 0.0),(800.0, 600.0))
  bounds.limit((900.0, 600.0), (100.0, 150.0))    //> res0: ar.pablitar.catchtheball.Vector2D = (-700.0, -450.0)
}