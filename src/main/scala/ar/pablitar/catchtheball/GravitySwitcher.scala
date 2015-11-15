package ar.pablitar.catchtheball

import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.events.constants.MouseButton

class GravitySwitcher extends GameComponent[CatchTheBallScene] {

  override def update(state: DeltaState) {
    if (state.isMouseButtonPressed(MouseButton.LEFT)) {
      this.getScene.gravityCenter = 
        Vector2D(state.getCurrentMousePosition.getX, state.getCurrentMousePosition.getY)
    }
  }
}