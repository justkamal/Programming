package hackerEarth;

import java.util.ArrayList;
import java.util.Hashtable;

public class MovieRating {

	public static class RatingCollectorImpl implements RatingCollector {
		private Hashtable<String, ArrayList<Double>> movieRatings;
		private Hashtable<String, Double> avgRating;

		public RatingCollectorImpl() {
			this.movieRatings = new Hashtable<String, ArrayList<Double>>();
			this.avgRating = new Hashtable<String, Double>();
		}

		@Override
		public void putNewRating(String movie, double rating) {
			ArrayList<Double> ratings = movieRatings.get(movie);
			if (ratings == null)
				ratings = new ArrayList<Double>();

			ratings.add(rating);
			movieRatings.put(movie, ratings);

			double avg = avgRating.get(movie) == null ? 0 : avgRating.get(movie);
			double newAvgRating = 0;
            double numberOfRatings = movieRatings.get(movie).size();
            newAvgRating = (avg * (numberOfRatings - 1) ) + rating/numberOfRatings;
			avgRating.put(movie, newAvgRating);
			
		}

		@Override
		public double getAverageRating(String movie) {
			return this.avgRating.get(movie);
		}

		@Override
		public int getRatingCount(String movie) {
			return this.avgRating.get(movie).intValue();
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface RatingCollector {
		// This is an input. Make note of this rating. Rating can be a double number
		// between 0 and 100.
		void putNewRating(String movie, double rating);

		// Get the average rating
		double getAverageRating(String movie);

		// Get the total number of ratings received for the movie
		int getRatingCount(String movie);
	}
	
	public static void main(String[] args) {
		RatingCollector a = new RatingCollectorImpl();
		a.putNewRating("A", 22.22);
		a.putNewRating("B", 33.33);
		a.putNewRating("A", 44.44);
		a.putNewRating("A", 66.66);
		a.putNewRating("B", 55.55);
		System.out.println(a.getAverageRating("A"));
		System.out.println(a.getAverageRating("B"));
	}
}
