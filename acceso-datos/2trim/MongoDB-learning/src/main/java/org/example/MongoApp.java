package org.example;

import com.mongodb.client.*;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class MongoApp {
    public static void main(String[] args) {
        // Conectar al servidor MongoDB (localhost por defecto)
        try (MongoClient mongoClient = MongoClients.create()) {
            // Seleccionar la base de datos 'sample_mflix'
            MongoDatabase sampleTrainingDB = mongoClient.getDatabase("sample_training");


            // 1a

            Document document2Stops = new Document("_id", new org.bson.types.ObjectId("10a9a39b732b6122f877fc31"))
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
            Document filterDocument = new Document("stops", new Document("$gte", 1));
            Document proyectionDocument = new Document("src_airport", 1).append("dst_airport", 1).append("airport.name", 1);
            MongoCollection<Document> collection = sampleTrainingDB.getCollection("routes");
            FindIterable<Document> result = collection.find(filterDocument).projection(proyectionDocument);
            result.forEach(r -> System.out.println(r.toJson()));

            // 1c
            Document filterDoc = new Document("_id", new Document("$eq", new org.bson.types.ObjectId("10a9a39b732b6122f877fc31")));
            Document updateDoc = new Document("$set", new Document("dst_airport", "FRA"));
            UpdateResult updateResult = collection.updateOne(filterDoc, updateDoc);
            System.out.println("Numero de documentos modificados: " + updateResult.getModifiedCount());

            // 1d
            Document newAirlineValues = new Document("airline", new Document("id", 1234)
                    .append("name", "Nueva Aerolínea")
                    .append("alias", "NA")
                    .append("iata", "NVA"));
            
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