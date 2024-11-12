package com.example.commentaire;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class CommentDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "comments.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_COMMENTS = "comments";
    private static final String COL_ID = "id";
    private static final String COL_COMMENT = "comment";
    private static final String COL_DATE = "date";
    private static final String COL_LIKES = "likes";
    private static final String COL_DISLIKES = "dislikes";

    public CommentDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Créer la table des commentaires
        String createTable = "CREATE TABLE " + TABLE_COMMENTS + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_COMMENT + " TEXT, " +
                COL_DATE + " TEXT, " +
                COL_LIKES + " INTEGER DEFAULT 0, " +
                COL_DISLIKES + " INTEGER DEFAULT 0)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

    // Ajouter un commentaire
    public void addComment(Comment comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_COMMENT, comment.getTexte());
        values.put(COL_DATE, comment.getDate());
        values.put(COL_LIKES, comment.getLikeCount());
        values.put(COL_DISLIKES, comment.getDislikeCount());
        db.insert(TABLE_COMMENTS, null, values);
    }

    // Récupérer tous les commentaires
    public ArrayList<Comment> getAllComments() {
        ArrayList<Comment> comments = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_COMMENTS, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COL_ID));
                String texte = cursor.getString(cursor.getColumnIndex(COL_COMMENT));
                String date = cursor.getString(cursor.getColumnIndex(COL_DATE));
                int likes = cursor.getInt(cursor.getColumnIndex(COL_LIKES));
                int dislikes = cursor.getInt(cursor.getColumnIndex(COL_DISLIKES));
                comments.add(new Comment(id, texte, date, likes, dislikes));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return comments;
    }

    public void updateComment(Comment comment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_COMMENT, comment.getTexte());
        values.put(COL_LIKES, comment.getLikeCount());
        values.put(COL_DISLIKES, comment.getDislikeCount());

        int rowsAffected = db.update(TABLE_COMMENTS, values, COL_ID + "=?", new String[]{String.valueOf(comment.getId())});

        // Debug: afficher le nombre de lignes affectées
        if (rowsAffected > 0) {
            System.out.println("Mise à jour réussie de " + rowsAffected + " lignes.");
        } else {
            System.out.println("Erreur : aucune mise à jour effectuée.");
        }
    }
    // Supprimer un commentaire
    public void deleteComment(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COMMENTS, COL_ID + "=?", new String[]{String.valueOf(id)});
    }
}
