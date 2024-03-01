package utilities;

import java.io.*;

public class Serializer <T extends Serializable> {
    public ByteArrayOutputStream Serialize(T obj) throws IOException {
        ByteArrayOutputStream outputBytes = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = new ObjectOutputStream(outputBytes);
        outputStream.writeObject(obj);
        outputStream.close();
        return outputBytes;
    }

    public T Deserialize(ByteArrayInputStream inputBytes) throws IOException, ClassNotFoundException {
        T deserializedObj = null;
        ObjectInputStream inputStream = new ObjectInputStream(inputBytes);
        deserializedObj = (T) inputStream.readObject();
        inputStream.close();
        return deserializedObj;
    }
}

