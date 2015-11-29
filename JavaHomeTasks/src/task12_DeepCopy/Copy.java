package task12_DeepCopy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Copy {

	static Object deepCopy(Object o) {
		byte[] byteArray = new byte[0];
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			byteArray = baos.toByteArray();
			ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Object type \"" + o.getClass().getSimpleName() + "\" is not "
					+ "serializable");
		}
		return null;
	}

}
