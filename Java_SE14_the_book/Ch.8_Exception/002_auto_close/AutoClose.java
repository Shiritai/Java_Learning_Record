public class AutoClose {
    public static void main(String [] args){
        try (var res = new Resource();
            var res2 = new BitTorrent()){ // the latter closes first!
            res.doMeow();
            res2.doDownload();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

class Resource implements AutoCloseable {
    void doMeow(){
        System.out.println("Meow ~");
    }
    @Override 
    public void close() throws Exception{
        System.out.println("Close Resource!");
    }
}

class BitTorrent implements AutoCloseable {
    void doDownload(){
        System.out.println("Downloading...");
    }
    @Override 
    public void close() throws Exception{
        System.out.println("Torrent halt!");
    }
}
