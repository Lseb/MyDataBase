MyDataBase

I used to practice on android studio for improve my skills on SQLite.

You can find 3 class:
  - Data: where you can change how you need your data
  - GererData: this class is for delete/add/update/...etc the new data
  - MySQLiteHelper: This class create the table
  
  
  In the main activity, don't forgot to use:
  
    @Override
    protected void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        datasource.close();
        super.onPause();
    }
