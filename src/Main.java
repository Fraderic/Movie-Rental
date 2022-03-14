import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	
	// Buat tempat nyimpan datanya yg bnyk
	// Arraylist 
	
	ArrayList<String> movieIdArr = new ArrayList<>();
	
	ArrayList<String> movieTitleArr = new ArrayList<>();
	
	ArrayList<String> genreArr = new ArrayList<>();
	
	ArrayList<Integer> ratingArr = new ArrayList<>();
	
	
	public Main() {
		menu();
	}
	
	
	
	void menu() {
		int menu = 0;
		
		System.out.println("===============");
		System.out.println("Movie Rental");
		System.out.println("===============");
		
		//syso + ctrl + space
		System.out.println("1. Add New Movie");
		System.out.println("2. View Movie (Ascending)");
		System.out.println("3. Exit");
		System.out.print("Choose >>> ");
	
		try {
			menu = scan.nextInt();
			scan.nextLine();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Must be Numeric ! ");
			System.out.println("");
			scan.nextLine();
			menu();
		}
		
		switch (menu) {
		
		case 1:
			
			addNewMovie();
			
			break;

		case 2:
			
			viewMovie();
			
			break;
			
		case 3:
			System.out.println("Terimakasih :D");
			System.exit(0);
			
			break;	

		
		}
		
		
		
		
		
		
		
	}

	void addNewMovie() {
		// Tambahkan Film
		 
		 String title, genre;
		 int rating = 0;
		 int price = 0;
		 
		 
		 // 3-20
		 
		do {
			System.out.print("Input Movie Title [3-20 char]: ");
			title = scan.nextLine();
			
		} while (title.length()< 3 || title.length()> 20);
		
		
		// Movie genre horor comedy action (sensitiv)
		
		 do {
			System.out.print("Input Movie Genre [Horror | Comedy | Action]: ");
			genre = scan.nextLine();
			
			// equals --> case sensitive
			//equalsIgnoreCase --> insensitive (yg tdk sensitif)
			
		} while (!(genre.equals("Horror")|| genre.equals("Comedy") || genre.equals("Action")));
	
	 // Movie rating 1-10
		 
		 do {
			 System.out.print("Input Movie Rating [1-10]: ");
			 
			 try {
				rating = scan.nextInt();
				 scan.nextLine();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Must be NUMERIC!");
				scan.nextLine();
			}
			 
		} while (rating<1 || rating>10);
		 
		 //GENERATE MOVIE ID
		 
		 String id ="";
		 int random;
		 
		 //Rumus Random yang diberikan jarak
		 //(Math.random()*(max-min+1) + min)
		 
		 //XX YYY
		 
		 // A to Z (X)
		 for(int i = 0; i<2; i++) {
			 random = (int)(Math.random()*(90-65+1)+65);
			 id+= String.valueOf((char) random);
		 }
	 
		 // 0 to 9 (Y)
		 for (int i = 0; i < 3; i++) {
			random = (int) (Math.random()*10);
			id += random;
		}
		 
		 System.out.println("Generate Movie ID: " + id);
		 
		 // Menu addition Price
		 //[Horror | Comedy | Action]:
		 
		 int additionPrice=0;
		 
		 if (genre.equals("Horror")) {
			 additionPrice = 3000;
			 
		} else if (genre.equals("Comedy")) {
			additionPrice = 4000;
			
		} else if (genre.equals("Action")) {
			additionPrice = 5000;
		}
		 
		 // panajng judul * 500 + add price
		 
		 price = (title.length()*500)+additionPrice;
		 
		 
		 //=====================================
		 // MAUSKIN DATA
		 
		 
		 movieIdArr.add(id);
		 movieTitleArr.add(title);
		 genreArr.add(genre);
		 ratingArr.add(rating);
		 
		 System.out.println("HOREYY BERHASIL ! ");
		 menu();
		 
	 }

	
	  void viewMovie() {
			// Ascend dan mau kasih liat
		  
		  if (movieTitleArr.size() == 0) {
			System.out.println("No Movie Found");
			menu();
		}
		  
		  int n = movieTitleArr.size();
		  
		  for (int i = 0; i < n-1; i++) {
			  for(int j = 0; j < n-1; j++) {
				  
				  if(movieTitleArr.get(j).compareTo(movieTitleArr.get(j+1))>0) {
					  String temp = movieTitleArr.get(j);
					  
					  movieTitleArr.set(j, movieTitleArr.get(j+1));
					  
					  movieTitleArr.set(j+1, temp);
					  
					  
					  // Movie id movieIdArr
					  
					  String temp2 = movieIdArr.get(j);
					  
					  movieIdArr.set(j, movieIdArr.get(j+1));				  
					  movieIdArr.set(j+1, temp2);
					  
					  // Movie Genre genreArr
					  
					  String temp3 = genreArr.get(j);
					  
					  genreArr.set(j, genreArr.get(j+1));				  
					  genreArr.set(j+1, temp3);
					  
					  
					  // Movie ratingArr (INT --> angka ratingnya)
					  int temp4 = ratingArr.get(j);
					  
					  ratingArr.set(j, ratingArr.get(j+1));				  
					  ratingArr.set(j+1, temp4);
					  
				  }
			  }
		}
		 
		  
		  System.out.println("========================");
		  System.out.println("NO | ID | TITLE | GENRE  | RATING");
		  System.out.println("========================");
		  
		  	
		  
		  for (int i = 0; i < n; i++) {
			  
			  System.out.println((i+1) + " | " + movieIdArr.get(i)+ " | " + movieTitleArr.get(i)
			  + " | " + genreArr.get(i) + " | " + ratingArr.get(i) );
			
		}
		  
		  System.out.println("========================");
		  System.out.println("");
		  
		  menu();
			
		}


	public static void main(String[] args) {
		new Main();
	}

}
