package main

import (
	"bufio"
	"fmt"
	"os"
)

func main (){
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var size int
	fmt.Fscanln(reader, &size)
	nums := make([]int, size)

	for index := 0 ; index < size; index++ {
		fmt.Fscanln(reader, &nums[index])
	}

	for indexX := 0; indexX < size; indexX++ {
		var node = nums[indexX]
		for indexY := indexX +1; indexY < size; indexY++ {
			if nums[indexY] < node {
				var tmp = nums[indexY]
				nums[indexY] = node
				nums[indexX] = tmp
				node = tmp
			}
		}
	}

	for index := 0 ; index < size; index++ {
		fmt.Fprintln(writer, nums[index])
	}
}