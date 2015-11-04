package ar.pablitar.catchtheball

/**
 * @author pablitar
 */

trait Bounds {
  def limit(v: Vector2D): Vector2D

  def limit(v: Vector2D, lowerRight: Vector2D): Vector2D
}
case class RectangularBounds(upperLeft: Vector2D, lowerRight: Vector2D) {
  def limit(v: Vector2D) = v.max(upperLeft).min(lowerRight)

  def limit(v: Vector2D, aLowerRight: Vector2D): Vector2D = RectangularBounds(upperLeft, lowerRight - aLowerRight).limit(v)
}