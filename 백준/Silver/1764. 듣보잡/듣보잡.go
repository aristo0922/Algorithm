package main

import (
	"os"
	"bufio"
	"fmt"
	"sort"
)

func main(){
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	var arr [2]int
	fmt.Fscanln(reader, &arr[0], &arr[1])

	names := make(map[string] int)

	var name string
	count := 0

	for i:=0; i< arr[0]; i++ {
		fmt.Fscanln(reader, &name);
		names[name]++
	}

	var result []string
	for i:=0; i< arr[1]; i++ {
		fmt.Fscanln(reader, &name);
		names[name]++

		if names[name] >= 2 {
			count++
			result = append(result, name)
		}
	}

	fmt.Fprintln(writer, count)

	sort.Strings(result)
	
	for i := 0; i< count; i++ {
		fmt.Fprintln(writer, result[i])
	}
}