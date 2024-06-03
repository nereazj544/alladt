package alladt.MongoDB;

import org.bson.types.ObjectId;

/**
 * okId
 * TODO: Clase para verificar el id 
 */
public class okId {
    public static boolean okId(String id) {
        try {
            new ObjectId();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("> El sistema ha detectado un error.");
            return false;
        }
    }
}