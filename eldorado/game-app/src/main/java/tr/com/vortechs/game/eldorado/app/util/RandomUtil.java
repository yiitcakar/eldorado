package tr.com.vortechs.game.eldorado.app.util;

import java.util.List;
import java.util.Random;

public class RandomUtil 
{
	private static Random random = new Random();
	
	public static <T> T getThenDropRandomItem(List<T> itemList) {
		int index = random.nextInt(itemList.size());
		T item = itemList.get(index);
		itemList.remove(index);
		return item;
	}
	
	public static int getRandomIntInRange(int range) {
		return random.nextInt(range);
	}
}
