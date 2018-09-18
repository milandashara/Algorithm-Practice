package fwd;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
    static void customSort(int[] arr) {

        Map<Integer,List<Integer>> frequencyListMap = new TreeMap<>();
        Map<Integer,Integer> numFreqMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int n = arr[i];
            numFreqMap.put(n,numFreqMap.getOrDefault(n,0)+1);
        }

        for(Map.Entry<Integer,Integer> numFreqEntry:numFreqMap.entrySet()){

            int n = numFreqEntry.getKey();
            int freq = numFreqEntry.getValue();
            List<Integer> list = frequencyListMap.get(freq);
            if (list == null){
                list = new ArrayList<>();
            }
            list.add(n);
            frequencyListMap.put(freq,list);
        }

        for (Map.Entry<Integer,List<Integer>> freqListEntry:frequencyListMap.entrySet()){

            List<Integer> list = freqListEntry.getValue();
            Collections.sort(list);
            for (Integer n:list){
                for (int i=0;i<freqListEntry.getKey();i++) {
                    System.out.println(n);
                }
            }
        }

    }

    static String[] getMovieTitles(String substr) {
        String webPage = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr;

        try (InputStream is = new URL(webPage).openStream();
             Reader reader = new InputStreamReader(is)) {

            Gson gson = new Gson();
            Movie movie = gson.fromJson(reader, Movie.class);

            String[] movieTitles = new String[Integer.parseInt(movie.getTotal())];

            int i=0;
            for (Data data:movie.getData()){
                movieTitles[i]=data.getTitle();
                i++;
            }

            for (int j=2;j<= Integer.parseInt(movie.getTotal_pages());j++){
                webPage=webPage+"&page="+j;
                try (InputStream is1 = new URL(webPage).openStream();
                     Reader reader1 = new InputStreamReader(is1)){

                     gson = new Gson();
                     movie = gson.fromJson(reader1, Movie.class);
                    for (Data data:movie.getData()){
                        movieTitles[i]=data.getTitle();
                        i++;
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }

            }


            Arrays.sort(movieTitles);
            return movieTitles;

        }catch (IOException e){
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String s[]){
        String sa[] = getMovieTitles("spiderman");

        for (String temp:sa){
            System.out.println(temp);
        }
    }

    public class Movie
    {
        private String total;

        private String per_page;

        private String page;

        private Data[] data;

        private String total_pages;

        public String getTotal ()
        {
            return total;
        }

        public void setTotal (String total)
        {
            this.total = total;
        }

        public String getPer_page ()
        {
            return per_page;
        }

        public void setPer_page (String per_page)
        {
            this.per_page = per_page;
        }

        public String getPage ()
        {
            return page;
        }

        public void setPage (String page)
        {
            this.page = page;
        }

        public Data[] getData ()
        {
            return data;
        }

        public void setData (Data[] data)
        {
            this.data = data;
        }

        public String getTotal_pages ()
        {
            return total_pages;
        }

        public void setTotal_pages (String total_pages)
        {
            this.total_pages = total_pages;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [total = "+total+", per_page = "+per_page+", page = "+page+", data = "+data+", total_pages = "+total_pages+"]";
        }
    }

    public class Data
    {
        private String Year;

        private String Type;

        private String Poster;

        private String imdbID;

        private String Title;

        public String getYear ()
        {
            return Year;
        }

        public void setYear (String Year)
        {
            this.Year = Year;
        }

        public String getType ()
        {
            return Type;
        }

        public void setType (String Type)
        {
            this.Type = Type;
        }

        public String getPoster ()
        {
            return Poster;
        }

        public void setPoster (String Poster)
        {
            this.Poster = Poster;
        }

        public String getImdbID ()
        {
            return imdbID;
        }

        public void setImdbID (String imdbID)
        {
            this.imdbID = imdbID;
        }

        public String getTitle ()
        {
            return Title;
        }

        public void setTitle (String Title)
        {
            this.Title = Title;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [Year = "+Year+", Type = "+Type+", Poster = "+Poster+", imdbID = "+imdbID+", Title = "+Title+"]";
        }
    }

}
