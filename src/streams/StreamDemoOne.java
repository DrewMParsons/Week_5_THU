package streams;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemoOne
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Stream<Integer> intStream = Stream.of(1,2,3,4,5,6,7,8,9);
		
		intStream.forEach(System.out::println);
		System.out.println("--------------");
		
		Integer[] intArr = {0,1,2};
		
		System.out.println(Stream.of(intArr).count());
		System.out.println("--------------");
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		
		list.stream().filter(s -> s>2).forEach(System.out::println);
		System.out.println("--------------");
		
		Set<String> binarySet = list.stream().map(Integer::toBinaryString).collect(Collectors.toSet());
		List<String> binaryList = list.stream().map(Integer::toBinaryString).collect(Collectors.toList());
		System.out.println(binarySet);
		System.out.println("--------------");
		System.out.println(binaryList);
		System.out.println("--------------");
		
		ArrayList<String> arrMatch = new ArrayList<String>();
		arrMatch.add("Hi Drew");
		arrMatch.add("Hi everyone");
		arrMatch.add("Hi you");
		arrMatch.add("lets learn the streams");
		
		boolean b = arrMatch.stream().allMatch(v -> v.startsWith("Hi"));
		System.out.println(b); //false
		arrMatch.stream().filter(n->n.startsWith("Hi")).forEach(System.out::println);
		System.out.println("--------------");
		
		arrMatch.stream().map(n -> n.substring(0, 2)).forEach(System.out::println);
		System.out.println("--------------");
		
		arrMatch.stream().filter(n->n.startsWith("Hi")).forEach(System.out::println);
		System.out.println("--------------");
		
		Stream<Integer> intStream2 = Stream.of(1,2,3,4,5,6,7,8,9);
		intStream2.filter(n->n%2==0).forEach(System.out::print);
		System.out.println("\n--------------");
		
		arrMatch.parallelStream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println("\n--------------");
		
		List<List<Integer> > number = new ArrayList<>();
        
        // adding the elements to number arraylist
        number.add(Arrays.asList(1, 2));
        number.add(Arrays.asList(3, 4));
        number.add(Arrays.asList(5, 6));
        number.add(Arrays.asList(7, 8));
        
		List<Integer> numberFlatTimesTwo = number.stream().flatMap(l ->l.stream()).collect(Collectors.toList());
		System.out.println("\n-------Multi Dimensional Array-------");
		System.out.println(number);
		System.out.println("\n-------After using FlatMap-------");
		System.out.println(numberFlatTimesTwo);
		
		//example returns List of all directories in  D: by name
		List<String> allDir =Arrays.stream(new File("C:\\").listFiles())
				.filter(File::isDirectory)
				.map(File::getName)
				.collect(Collectors.toList());
		System.out.println(allDir);
	}

}
