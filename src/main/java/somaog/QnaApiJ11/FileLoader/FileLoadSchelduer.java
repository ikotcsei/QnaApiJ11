package somaog.QnaApiJ11.FileLoader;

/*
   ez a class ca 60 masodpercenket ellenorzi h volt e a fileokban modositas, es ha igen
   reloadolja oket a memoriaba. a memoriat szinkronizalni kell az iras idejere.
   - read all files in root dir, print msg v. read all files listed in a file
   - add new file : dinamikus menuvaltoztatas :
        polling  : frontend asks for files / names every x sec
        long polling : frontend asks, server holds it open until changes happen
        SSE : open one connection where : server notify's frontend - SSE
        ups n downs : ... , sclae well ? ,

*
*/
public class FileLoadSchelduer {
}
