package meeldetuletus;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.simple.JSONObject;

public class Car {
	
	String mark;
	String mudel;
	int võimsus;
	ArrayList<String> kasutajad = new ArrayList<String>();
	
	public static void main (String args[]) {
		ArrayList<String> opeli_kasutajad = new ArrayList<String>();
		opeli_kasutajad.add("Aadu");
		opeli_kasutajad.add("Eedu");
		ArrayList<String> volvo_kasutajad = new ArrayList<String>();
		volvo_kasutajad.add("Uudu");
		volvo_kasutajad.add("Iidu");
		Car opel = new Car("Opel", "Astra", 70, opeli_kasutajad);
		Car volvo = new Car("Volvo", "V70", 100, volvo_kasutajad);
		
		//System.out.println(opel.createJSON(opel));
		System.out.println(opel.createCar(opel.createJSON(opel)));		
		System.out.println(opel.createJSON(opel, volvo));
	}
	
	public Car(String mark, String mudel, int võimsus, ArrayList<String> kasutajad) {
		this.mark = mark;
		this.mudel = mudel;
		this.võimsus = võimsus;
		this.kasutajad = kasutajad;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMudel() {
		return mudel;
	}

	public void setMudel(String mudel) {
		this.mudel = mudel;
	}

	public int getVõimsus() {
		return võimsus;
	}

	public void setVõimsus(int võimsus) {
		this.võimsus = võimsus;
	}

	public ArrayList<String> getKasutajad() {
		return kasutajad;
	}

	public void setKasutajad(ArrayList<String> kasutajad) {
		this.kasutajad = kasutajad;
	}

	@Override
	public String toString() {
		return "[\"mark=" + mark + "\"" + ", \"mudel=" + mudel + "\"" + ", \"võimsus=" + võimsus + "\"" + ", \"kasutajad=" + kasutajad + "\"" +"]";
	}
	
	public ArrayList<String> getList (String str) {
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.substring(1, str.length() - 1).split(", ")));
		return list;
	}
	
	public JSONObject createJSON (Car car) {
		JSONObject car_obj = new JSONObject();    
		car_obj.put("mark",car.getMark());    
		car_obj.put("mudel", car.getMudel());
		car_obj.put("võimsus", car.getVõimsus());
		car_obj.put("kasutajad", car.getKasutajad());
		System.out.println(car_obj.toString());
		return car_obj;
	}
	
	public Car createCar (JSONObject car) {
		Car car_object = new Car(car.get("mudel").toString(), car.get("mark").toString(), Integer.parseInt(car.get("võimsus").toString()), getList(car.get("kasutajad").toString()));
		return car_object;
	}
	
	public JSONObject createJSON(Car... cars) {
		JSONObject cars_obj = new JSONObject();
		int index = 1;
		for (Car car : cars) {
			cars_obj.put("car" + index, car);
			index++;
		}
		return cars_obj;
	}
	
}
