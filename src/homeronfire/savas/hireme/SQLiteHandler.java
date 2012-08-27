package homeronfire.savas.hireme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHandler {
	
	public static final String KEY_ROW = "_id";
	public static final String KEY_NAME = "_name";
	public static final String KEY_EMAIL = "_email";
	
	private static final String DB_NAME = "ContactListdb";
	private static final String DB_TABLE = "contactListTable";
	private static final int DB_VERSION = 1;
	
	private DbHelper dbHelper;
	private SQLiteDatabase contactDb;
	private Context context;
	
	public SQLiteHandler(Context context){
		this.context = context;
	}
	
	public SQLiteHandler open()throws SQLException{
		dbHelper = new DbHelper(context);
		contactDb = dbHelper.getWritableDatabase();
		return this;
	}
	
	public long persistEntry(String name, String email) {
		ContentValues cValues = new ContentValues();
		cValues.put(KEY_NAME, name);
		cValues.put(KEY_EMAIL, email);
		return contactDb.insert(DB_TABLE, null, cValues);		
	}
	
	public void deleteEntry(long intRow) throws SQLException {
		contactDb.delete(DB_TABLE, KEY_ROW + "=" + intRow, null);		
	}

	public String getID() {
		String[] idColumns = new String[]{KEY_ROW, KEY_NAME, KEY_EMAIL};
		Cursor cursor = contactDb.query(DB_TABLE, idColumns, null, null, null, null, null);
		String result = "";
		
		int iRow = cursor.getColumnIndex(KEY_ROW);				
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
			result += cursor.getString(iRow) + "\n";
		}
		
		return result;
	}
	
	public String getName() {
		String[] nameColumns = new String[]{KEY_ROW, KEY_NAME, KEY_EMAIL};
		Cursor cursor = contactDb.query(DB_TABLE, nameColumns, null, null, null, null, null);
		String result = "";
	
		int iName = cursor.getColumnIndex(KEY_NAME);
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
			result += cursor.getString(iName) + "\n";
		}
		
		return result;
	}
	
	public String getEmail() {
		String[] emailColumns = new String[]{KEY_ROW, KEY_NAME, KEY_EMAIL};
		Cursor cursor = contactDb.query(DB_TABLE, emailColumns, null, null, null, null, null);
		String result = "";
		
		int iEmail = cursor.getColumnIndex(KEY_EMAIL);
		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
			result += cursor.getString(iEmail) + "\n";
		}
		return result;
	}

	
	public void close(){
		dbHelper.close();
	}
	
	private static class DbHelper extends SQLiteOpenHelper {
		
		public DbHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION); 
		}		

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + DB_TABLE + " (" +
					KEY_ROW + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " +
					KEY_EMAIL + " TEXT NOT NULL);"
					);
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
			onCreate(db);			
		}
		
	}

	
	
	
	

}
