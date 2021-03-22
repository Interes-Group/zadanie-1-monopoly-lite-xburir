package sk.stuba.fei.uim.oop.tiles;


public abstract class Tile {
   protected String type;
   protected String icon;

   public Tile(){
       this.type = "None";
       this.icon = ".";
   }

   public String getIcon(){
       return icon;
   }

   public String getType(){
       return type;
   }
}
