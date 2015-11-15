package ar.pablitar.catchtheball

import com.uqbar.vainilla.GameScene

/**
 * @author pablitar
 */
class CatchTheBallScene extends GameScene {
  
  var gravityCenter = Vector2D(400, 300)
  
  this.addComponent(BallSpawner)
  this.addComponent(BallCatcher)
  this.addComponent(new GravitySwitcher())
  this.addComponent(new Cursor)
}