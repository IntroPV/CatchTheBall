package ar.pablitar.catchtheball

import com.uqbar.vainilla.DesktopGameLauncher
import com.uqbar.vainilla.Game
import java.awt.Dimension
import scala.util.Random

/**
 * @author pablitar
 */
object CatchTheBallGame extends App {
  val width = 800
  val height = 600
  new DesktopGameLauncher(new CatchTheBallGame()).launch()

  val randomizer = new Random
  
  def bounds = RectangularBounds((0.0, 0.0), (width.toDouble, height.toDouble))
}

class CatchTheBallGame extends Game {
  def getDisplaySize(): Dimension = new Dimension(CatchTheBallGame.width, CatchTheBallGame.height)

  def getTitle(): String = {
    "CatchTheBall"
  }

  def setUpScenes(): Unit = {
    this.setCurrentScene(new CatchTheBallScene())
  }

  def initializeResources(): Unit = {
    //Nada por ahora
  }
}