import java.util.*;
import java.io.*;
public class Valodik{
	public static void main(String[] args)throws Throwable{
		while(true){
		ArrayList<Integer> arrList = new ArrayList<>();
		while(arrList.size()!=21){
			int j = (int) (Math.random()* 30 + 1);
			if(!arrList.contains(j)){
				arrList.add(j); // Добавление рандомных элементов в массив
			}
		}
			game(arrList); //Начало игры
			System.out.println("Сыграем еще разок? Y - yes");
			Scanner sc = new Scanner(System.in);
			String answer = sc.nextLine().toLowerCase();
			if(answer.equals("y") || answer.equals("yes")){
				continue;
			}else break;
		}
		
	}
	private static void game(ArrayList<Integer> list) throws Throwable{
	
		int[] arr1 = new int[7];
		int[] arr2 = new int[7];
		int[] arr3 = new int[7];

		System.out.println("Выберите одно число и напишите в каком ряду оно находится");
		int x=0;
		while(x<3){
			int j=0;
			x++;
			for(int i=0; i<arr1.length; i++){
				arr1[i] = list.get(j);
				arr2[i] = list.get(j+1);
				arr3[i] = list.get(j+2);
				j+=3;
			}
			for(int i=0;i<arr1.length;i++){
				System.out.println(arr1[i] + "\t\t" + arr2[i] + "\t\t" + arr3[i]);
				Thread.sleep(250);
			}
			int n = testAnswer();
			list.clear();
			if(n==1){ 
				list = newList(arr3, arr1, arr2);
			}else if(n==2){
				list = newList(arr1, arr2, arr3);
			}else if(n==3){
				list = newList(arr2, arr3, arr1);
			}

			if(x==1){
				System.out.println("Отлично, осталось повторить еще два раза");
			}else if(x==2){
				System.out.println("Пока все идет по плану, давай еще разочек.");
			}else{
				System.out.println("Кажется я начинаю догадываться какое число ты загадал");
			}
		}
		System.out.println("Ну что, готов? Все было слишком просто)");
		Thread.sleep(2000);
		System.out.println("Твое число");
		for(int i = 0; i<10; i++){
			Thread.sleep(300);
			System.out.print(".");
		}
		System.out.println("\n" + list.get(10));
	}

	private static ArrayList newList(int[] a1, int[] a2, int[] a3){ //Вот тут начинается магия!
		ArrayList<Integer> list = new ArrayList<Integer>();

		for(int i=0; i<a1.length; i++){
			list.add(a1[i]);
		}
			for(int i=0; i<a2.length; i++){
			list.add(a2[i]);
		}
			for(int i=0; i<a3.length; i++){
			list.add(a3[i]);
		}

		return list;
	}

	private static int testAnswer() throws Exception{
		System.out.println("В каком ряду вашe выбранное число?");
		Scanner scanner = new Scanner(System.in);
		String[] str = scanner.nextLine().split("");
		if(str==null){
			return testAnswer();
		}
		else if(str[0].equals("")){
			System.out.println("Пустая строка не пройдет!");
			return testAnswer();
		}
		else if(str.length!=1){
			System.out.println("Вы ввели неверные данные, попробуйте ввести символ от 1 до 3");
			return testAnswer();
		}
		for(String s : str){
    		for (char c : s.toCharArray()){
        		if (c < '1' || c > '3'){
        			System.out.println("Вы ввели неверные данные");
        			return testAnswer();
        		}
    		}
		}
		return Integer.parseInt(str[0]);
	}
}
