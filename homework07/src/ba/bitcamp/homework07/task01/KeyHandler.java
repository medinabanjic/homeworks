package ba.bitcamp.homework07.task01;

	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	
	public class KeyHandler extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				Task01.getInstance().moveRight();	
			} 
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				Task01.getInstance().moveLeft();
			} 
			if(e.getKeyCode() == KeyEvent.VK_UP){
				Task01.getInstance().moveUp();
			} 
			if(e.getKeyCode() == KeyEvent.VK_DOWN){
				Task01.getInstance().moveDown();;
			} 
		}
}
