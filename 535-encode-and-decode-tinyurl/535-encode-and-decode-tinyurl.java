public class Codec {

    // Encodes a URL to a shortened URL.
     Map<String, String> map = new HashMap<>();
    String base64="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-";
    String url = "https://tinyurl.com/";
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return url + getHashKey(longUrl);
    }
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String[] shortSplit=shortUrl.split("/");
        String hash = shortSplit[shortSplit.length - 1];
        return map.get(hash);
    }
    
    //explaination
    public String getHashKey(String longUrl){
        //key string builder for appending the hash value
        StringBuilder key = new StringBuilder();
        
        // my hash code will be of 6 character
        // my base64 string is having 64 characters
        // so at each position in 6 character i have an option to choose 64 characters
        // posisbilities of hash here is 64 power 6, we can extend to 8 or 12 also
        // then it will be 64 power 8 or 64 power 12
        for (int i = 0;i<6;i++){   //limit can go upto 8 or 12 here
            //creating a random object and getting a random number from 1 to 63
            Random rand = new Random();
            int randIndex = rand.nextInt(base64.length()-1);
            //whatever value I get i pick that value from base64 string, line no 4
            //and append to the string builder, key
            key.append(base64.charAt(randIndex));
        }
        
        String hash = key.toString();
        //if map already contains the key return the hash which does not exist
		// by calling getHashKey(longUrl) again
        if (map.containsKey(hash)) return getHashKey(longUrl);
        //if map do not contains i will store in map and return hash
        map.put(hash, longUrl);
        return hash;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));