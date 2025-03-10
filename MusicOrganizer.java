import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    
    /**
     * Listamos todos los archivos almacenados en el Array.
     */
    public void listAllFiles()
    {
        int position = 1;
        for(String archivo : files){
            System.out.println(position + ": " + archivo);
            position ++;
        }
    }
    
    /**
     * Listamos de aquellos archivos 
     * que coinciden con la cadena que buscamos.
     */
    public void listMatching(String searchString)
    {
        boolean comprobacionCoincidencias = false;
        for(String filename : files){
            if(filename.contains(searchString)){
                System.out.println(filename);
                comprobacionCoincidencias = true;
            }
        }
        
        if (!comprobacionCoincidencias){
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
    }
    
    /**
     * Reproduce los primeros segundos de las canciones 
     * del artista especificado por el parametro introducido.
     */
    public void cacionesArtista(String artista){
        for (String filename : files){
            if(filename.contains(artista)){
                player.playSample(filename);
            }
        }
    }
    
    /**
     * Localizar el �ndice del primer archivo que se corresponde con 
     * la cadena de b�squeda indicada.
     * @param searchString La cadena que hay que buscar.
     * @return El �ndice de la primera aparici�n, es decir -1 si
     * no se encuentra ninguna correspondencia.
     */
    public int findFirst(String searchString)
    {
        int index = 0;
        // Indicar que vamos a seguir buscando hasta encontrar una correspondecia.
        boolean searching = true;
        int aDevolver = 0;
        int tama�oArchivos = files.size();
        while(searching && index < tama�oArchivos){
            String filename = files.get(index);
            if(filename.contains(searchString)){
                //Una correspondencia. Podemos dejar de buscar.
                searching = false;
            }
            else {
                //Pasar al siguiente elemento.
                index++;
            }
        }
        if(searching){
            //No la hemos encontrado.
            aDevolver = -1;
        }
        else {
            //Devolver la ubicacion donde la hayamos encontrado.
            aDevolver = index;
        }
        return aDevolver;
    }
}
