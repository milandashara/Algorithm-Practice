package redmart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * http://geeks.redmart.com/2015/10/26/1000000th-customer-prize-another-programming-challenge/
 * @author Milan
 *
 */
public class Main {

	public static void main(String[] args) {
		List<Product> products = Main.readProducts();

		// products are sorted by k. where k calculated such a way that higher
		// the value of k, more space-price utilization.
		// goal is to earn more price with minimum space occupied.
		Collections.sort(products);

		Tote tote = new Tote();// create tote

		for (Product p : products) {

			tote.add(p);// fill the tote

		}
		
		int sumOfProductID = 0;
		for (Product p : tote.products) {
			sumOfProductID = sumOfProductID + p.productId;
			System.out.println(p);
		}
		System.out.println("Sum of product ID :" + sumOfProductID);
	}
	
	/**
	 * read product from csv and reture list of products
	 * @return
	 */
	public static List<Product> readProducts() {
		String csvFile = "src/redmart/products.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		List<Product> products = new ArrayList<Product>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] productStr = line.split(cvsSplitBy);
				Product product = new Product(Integer.parseInt(productStr[0]),
						Integer.parseInt(productStr[1]),
						Integer.parseInt(productStr[2]),
						Integer.parseInt(productStr[3]),
						Integer.parseInt(productStr[4]),
						Integer.parseInt(productStr[5]));
				if (product.height <= Tote.tote_height
						&& product.width <= Tote.tote_width
						&& product.length <= Tote.tote_length) {
					products.add(product);

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		//System.out.println("Done");
		return products;
	}
}

/**
 * 
 * @author Milan
 *
 */
class Tote {
	List<Product> products = new ArrayList<Product>();
	public static int tote_length = 45;
	public static int tote_width = 30;
	public static int tote_height = 35;
	public static int volume = tote_length * tote_width * tote_height;

	public static int getVolume() {
		return volume;
	}

	public double remaining_length = tote_length;
	public double remaining_width = tote_width;
	public double remaining_height = tote_height;
	
	/**
	 * replace product with existing if it can fit and is high value. It is called only after tote is full
	 * @param product
	 */
	public void replaceWithRightProduct(Product product) {
		double max = -1;
		Product temp = null;
		// Collections.sort(products,new PriceComparator());
		for (Product p : products) {
			if ((product.price >= p.price && isReplaceable(p, product))) {
				products.remove(p);
				//System.out.println("removed" + p);
				products.add(product);
				remaining_height = remaining_height + p.height - product.height;
				remaining_width = remaining_width + p.width - product.width;
				remaining_length = remaining_length + p.length - product.length;
				break;
			}
		}

	}
	
	/**
	 * is p2 replaceable with p1
	 * @param p1
	 * @param p2
	 * @return
	 */
	public boolean isReplaceable(Product p1, Product p2) {
		if (remaining_height + p1.height - p2.height >= 0
				&& remaining_width + p1.width - p2.width >= 0
				&& remaining_length + p1.length - p2.length >= 0)
			return true;
		else
			return false;
	}
	
	/**
	 * Add Product p to tote
	 * @param p
	 * @return
	 */
	public boolean add(Product p) {

		if (p.length <= remaining_length && p.width <= remaining_width
				&& p.height <= remaining_height) {
			products.add(p);
			remaining_height = remaining_height - p.height;
			remaining_width = remaining_width - p.width;
			remaining_length = remaining_length - p.length;
			return true;
		} else {
			replaceWithRightProduct(p);
		}
		return false;
	}

}

/**
 * 
 * @author Milan
 *
 */
class Product implements Comparable<Product> {
	int productId;
	double price;
	double length;
	double width;
	double height;
	int weight;
	double k;// sort product in descending order of k

	public double getVolume() {
		return length * height * width;
	}

	public Product(int productId, int price, int length, int width, int height,
			int weight) {
		this.productId = productId;
		this.price = price;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		
		this.k = (double) (this.price * (get_n()));


	}
	
	/**
	 *  n is num of this product that can fill tote
	 * @return
	 */
	public double get_n() {
		double length_ratio = new Double(Tote.tote_length / length);
		double width_ratio = new Double(Tote.tote_width / width);
		double height_ratio = new Double(Tote.tote_height / height);

		if (length_ratio < width_ratio) {
			if (length_ratio < height_ratio)
				return length_ratio;
			else
				return height_ratio;
		} else if (width_ratio < height_ratio)
			return width_ratio;
		else
			return height_ratio;
	}
	
	/**
	 * natural order of sorting by k in descending order
	 */
	public int compareTo(Product o) {
		// TODO Auto-generated method stub
		int comp = Double.valueOf(o.k).compareTo(Double.valueOf(this.k));
		if (comp == 0) {
			return Integer.valueOf(o.weight).compareTo(
					Integer.valueOf(this.weight));
		}
		return comp;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", price=" + price
				+ ", length=" + length + ", width=" + width + ", height="
				+ height + ", weight=" + weight + ", k=" + k + "]";
	}

}

/**
 * Sorting product by price
 * @author Milan
 *
 */
class PriceComparator implements Comparator<Product> {

	public int compare(Product o1, Product o2) {
		return Double.valueOf(o2.price).compareTo(Double.valueOf(o1.price));
	}

}
