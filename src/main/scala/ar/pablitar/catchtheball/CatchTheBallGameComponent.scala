package ar.pablitar.catchtheball

import com.uqbar.vainilla.GameComponent

/**
 * @author pablitar
 */
class CatchTheBallGameComponent extends GameComponent[CatchTheBallScene] {

  def position_=(position: Vector2D) = {
    this.setX(position.x1)
    this.setY(position.x2)
  }

  def position: Vector2D = (getX, getY)
}