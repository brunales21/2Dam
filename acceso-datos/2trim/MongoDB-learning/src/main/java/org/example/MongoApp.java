package org.example;

import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Updates.set;

public class MongoApp {
    public static void main(String[] args) {
        // Conectar al servidor MongoDB (localhost por defecto)
        try (MongoClient mongoClient = MongoClients.create()) {
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_training");
            ObjectId objectId = new org.bson.types.ObjectId("10a9a39b732b6122f877fc31");

            // 1a
            Document document2Stops = new Document("_id", objectId)
                    .append("airline", new Document("id", 410)
                            .append("name", "bruno-air-line")
                            .append("alias", "2B")
                            .append("iata", "ARD"))
                    .append("src_airport", "ARG")
                    .append("dst_airport", "ESP")
                    .append("codeshare", "")
                    .append("stops", 2)
                    .append("airplane", "CR2");

            createDocument(sampleTrainingDB, "routes", document2Stops);

            // 1b
            MongoCollection<Document> collection = sampleTrainingDB.getCollection("routes");
            Bson filterDocument = gte("stops", 1);
            Bson projection = Projections.fields(Projections.include("src_airport", "dst_airport", "airline.name"), Projections.excludeId());
            FindIterable<Document> result = collection.find(filterDocument).projection(projection);
            result.forEach(r -> System.out.println(r.toJson()));

            // 1c
            UpdateResult updateResult = collection.updateOne(eq("_id", objectId), set("dst_airport", "FRA"));
            System.out.println("Numero de documentos modificados: " + updateResult.getModifiedCount());

            // 1d
            Document newAirlineValues = new Document("airline", new Document("id", 1234)
                    .append("name", "Nueva Aerolínea")
                    .append("alias", "NA")
                    .append("iata", "NVA"));


            UpdateResult updateResult1 = collection.updateOne(eq("_id", objectId), set("airline", newAirlineValues));
            System.out.println("Numero de documentos modificados" + updateResult1.getModifiedCount());
            
            // 1e
            DeleteResult deleteResult = collection.deleteOne(eq("_id", objectId));
            System.out.println("Numero de documentos borrados: " + deleteResult.getDeletedCount());


            /*
            2. Si quisieras diseñar un DAO para la colección Routes, ¿qué métodos crearías?
            ¿Qué recibirían los métodos? ¿podrías evitar que te pasaran un documento que
            no tuviera nada que ver con una ruta aérea? En caso afirmativo, explica cómo.

            Crearia los metodos crud.
            Create: en este caso sobrecargaría el método. Recibiria un objeto POJO de tipo "Routes" o un documento route.
            Read: recibiria el id del documento a leer
            Update: recibiria el id del documento y un documento con los campos a actualizar o el POJO
            Delete: recibiria el id del documento a borrar

            Sí, podría evitar que se pasara un documento que no fuera una ruta aérea.

            Al principio pensé en el método "isRoute(id)" o "isRoute(document)", el cuál
            devolvería true si los campos de la clase coincidiesen con los del document.

            Después, entró un poco de corriente a mi habitación y se me ocurrió la siguiente idea.
            Se trata de parametrizar y generalizar la funcion a través de reflexión.

            Crearía un método boolean que reciba un objeto y un id o un document. Devolvería true si todos los campos
            del objeto coincidiesen con las claves del documento. Todos los elementos del document.keyset()
            deberian coincidir con los campos del POJO.
            Este método lo llamaría dentro de los métodos CRUD.


            crudMethod(id) {
                if (matchesClass(Routes.class, id)) {
                    //lógica
                {
            }

            crudMethod(document) {
                if (matchesClass(Routes.class, document)) {
                    //lógica
                {
            }

            Método reflexivo.
            El método estático "matchesClass(arg1, arg2)" estaría en una clase Utils.
            El metodo estaría sobrecargado.

            static boolean matchesClass(Object obj, Document doc) {
                // cada elemento de obj.getClass().getDeclaredFields() tiene que
                // coincidir con los elementos de doc.keySet()
            }

            static boolean matchesClass(Object obj, ObjectId id) {
                return matchesClass(obj.getClass(), getDocumentById(collectionName, id));
            }

            */
        } catch (Exception e) {
            System.err.println("Error al conectar a la base de datos: "
                    + e.getMessage());
        }
    }

    public static void createDocument(MongoDatabase db, String collectionName, Document document) {
        MongoCollection<Document> rCollection = db.getCollection(collectionName);
        rCollection.insertOne(document);
    }
}
