package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    private static int id;
    static int[] arr = new int[5];

    public static void main(String[] args) {
        CrazyLogger lg = new CrazyLogger();
        try {
            for (id = arr.length+1; id >=0; id--) {
                arr[id] = 1/id;
            }

        } catch (IndexOutOfBoundsException | ArithmeticException e) {
            System.out.println(lg.log(e, CrazyLogger.Level.ERROR));
        }
        lg.flush();
    }

    public static class CrazyLogger extends Throwable {

        private static HashMap<Integer, StringBuilder> data = new HashMap<>();
        private static final String TAG = "Module: ";
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
        public enum Level {WARNING, ERROR}

        public HashMap<Integer, StringBuilder> log(Object o, Level l) {
            for (id = 0; id < arr.length; id++) {
                StringBuilder sb = data.get(id);
                if (sb == null) sb = new StringBuilder();
                if (o instanceof Exception) {
                    Exception e = (Exception) o;
                    sb.append(sdf.format(new Date())).append(" ").append("-").append(TAG).append(TAG.codePointAt(id)).append(" ").append(l.name()).append(": ").append(e.toString()).append("\n");
                } else {
                    sb.append(TAG).append(" ").append(l.name()).append(": ").append(o.toString()).append("\n");
                }
                data.put(id, sb);
            }
            return data;
        }
        public Object finder(){
            if (TAG == "Module: "){
                return CrazyLogger.data;
            }
            else{
                return Level.ERROR;
            }
        }

        public void flush() {
            flush(null);
        }

        public void flush(Map<String, String> params) {
            for (int id : arr) {
                StringBuilder sb = data.get(id);
                if (sb != null) {
                    if (params != null) {
                        for (String key : params.keySet()) {
                            System.err.print("&" + key + "=" + params.get(key));
                        }
                    }
                    System.err.println(sb.toString());
                    data.remove(id);
                }
            }
        }
    }

}
