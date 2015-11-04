package ar.pablitar.catchtheball

import com.uqbar.vainilla.GameScene

/**
 * @author pablitar
 */
class CatchTheBallScene extends GameScene {
  this.addComponent(BallSpawner)
  this.addComponent(BallCatcher)
}