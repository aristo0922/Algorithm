package main

import (
	"fmt"
	"os"
	"bufio"
)

func factorial(num int) int {
	if num > 1 {
		return factorial(num-1) * num
	}
	return 1
}

func main(){

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var N int
	fmt.Fscanln(reader, &N)

	fmt.Fprintln(writer, factorial(N))
}