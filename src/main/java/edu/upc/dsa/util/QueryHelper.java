package edu.upc.dsa.util;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        for (String field: fields) {
            sb.append(", ").append(field);
        }

        sb.append(") VALUES (?");

        for (String field: fields) {
            sb.append(", ?");
        }

        sb.append(")");

        return sb.toString();
    }

    public static String createQueryINSERTSIMPLE(Object entity){
        StringBuffer sb = new StringBuffer("INSERT INTO ");

        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        for (String field: fields) {
            sb.append(field).append(", ");
        }

        sb.delete(sb.length() -29, sb.length());

        sb.append(") VALUES (");

        for (String field: fields) {
            sb.append("?, ");
        }

        sb.delete(sb.length()-11, sb.length());

        sb.append(")");

        return sb.toString();
    }

    public static String createQuerySELECT(Class entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getSimpleName());
        sb.append(" WHERE iduser = ?");

        return sb.toString();
    }
    public static String createQuerySELECT(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(entity.getClass().getSimpleName());
        sb.append(" WHERE iduser = ?");

        return sb.toString();
    }

    public static String createQueryDELETE(Object entity){
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE FROM ").append(entity.getClass().getSimpleName()).append(" ");
        sb.append("WHERE IDUSER = ?");

        return sb.toString();
    }

    public static String createQueryDELETEALL(Object entity){
        StringBuffer sb = new StringBuffer();
        sb.append("DELETE * FROM ").append(entity.getClass().getSimpleName()).append(" ");
        sb.append("WHERE Nickname = ?");

        return sb.toString();
    }

    public static String createQueryUPDATE(Object entity) {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ").append(entity.getClass().getSimpleName()).append(" ").append("SET");

        String[] fields = ObjectHelper.getFields(entity);
        for(String field: fields){
            sb.append(" ").append(field);
            sb.append(" = ?,");
        }
        sb.delete(sb.length() -1, sb.length());

        sb.append(" WHERE iduser = ?");

        return sb.toString();
    }

    public static String createQueryUPDATE2(Object entity) {
        boolean noclass = false;
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ").append(entity.getClass().getSimpleName()).append(" ").append("SET");

        String[] fields = ObjectHelper.getFields(entity);
        for(String field: fields){
            sb.append(" ").append(field);
            sb.append(" = ?,");
        }
        sb.delete(sb.length() -1, sb.length());

        sb.append(" WHERE  = ?");

        return sb.toString();
    }

    public static String createQueryIDUSER(Class theClass){
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT iduser FROM ").append(theClass.getSimpleName()).append(" ");
        sb.append("WHERE nickname = ?").append(" ").append("AND password = ?");

        return sb.toString();
    }

    public static String createQueryEXISTEUSER(Class theClass) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT IDUSER FROM ").append(theClass.getSimpleName()).append(" ");
        sb.append("WHERE nickname = ?").append(" ");

        return sb.toString();
    }

}
