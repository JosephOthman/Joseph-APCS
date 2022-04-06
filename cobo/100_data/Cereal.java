public class Cereal {
  private String _name;
  private String _type;
  private int _cals;
  private int _protein;
  private int _fat;
  private int _sodium;
  private double _fiber;
  private double _carbs;
  private int _sugar;
  private int _potassium;
  private int _vitamins;
  private int _shelf;
  private double _weight;
  private double _cups;
  private double _rating;

  public Cereal(String name, String type, int cals, int protein, int fat, int sodium, double fiber, double carbs, int sugar, int potassium, int vitamins, int shelf, double weight, double cups, double rating) {
    this._name = name;
    this._type = type;
    this._cals = cals;
    this._protein = protein;
    this._fat = fat;
    this._sodium = sodium;
    this._fiber = fiber;
    this._carbs = carbs;
    this._sugar = sugar;
    this._potassium = potassium;
    this._vitamins = vitamins;
    this._shelf = shelf;
    this._weight = weight;
    this._cups = cups;
    this._rating = rating;
  }

  public String toString() {
    String retString = "";
    retString = "name: "  + _name + "; " + "type: "  + _type + "; " + "cals: "  + _cals + "; " + "protein: "  + _protein + "; " + "fat: "  + _fat + "; " + "sodium: "  + _sodium + "; " + "fiber: "  + _fiber + "; " + "carbs: "  + _carbs + "; " + "sugar: "  + _sugar + "; " + "potassium: "  + _potassium + "; " + "shelf: "  + _shelf + "; " + "weight: "  + _weight + "; " + "cups: "  + _cups + "; " + "rating: "  + _rating + ";";
    return retString;
  }

  public String getName() {
      return _name;
  }

  public String getType() {
      return _type;
  }

  public int getCals() {
      return _cals;
  }

  public int getProtein() {
      return _protein;
  }

  public int getFat() {
      return _fat;
  }

  public int getSodium() {
      return _sodium;
  }

  public double getFiber() {
      return _fiber;
  }

  public double getCarbs() {
      return _carbs;
  }

  public int getSugar() {
      return _sugar;
  }

  public int getPotassium() {
      return _potassium;
  }

  public int getVitamins() {
      return _vitamins;
  }

  public int getShelf() {
      return _shelf;
  }

  public double getWeight() {
      return _weight;
  }

  public double getCups() {
      return _cups;
  }

  public double getRating() {
      return _rating;
  }

  public static void main(String[] args) {
    Cereal grapeNutz = new Cereal ("Grape Nuts", "C", 150, 5, 350, 9, 14.0, 11.0, 9, -1, 25, 2, 1.53, .666, 69.420);
    System.out.println(grapeNutz);

    Cereal wheatNutz = new Cereal ("Wheat Nuts", "C", 149, 5, 320, 5, 16.0, 13.0, 11, 4, 22, 3, 1.63, .222, 42.069);
    System.out.println(wheatNutz);
  }

}
