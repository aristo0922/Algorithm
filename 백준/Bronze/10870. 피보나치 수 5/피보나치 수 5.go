package main

import (
	"fmt"
	"bufio"
	"os"
)

func calc(index int) int{

	if index <= 0 {
		return 0
	}

	if index == 1 {
		return 1
	}

	if index == 2 {
		return 1
	}

	return calc(index-1) + calc(index-2)
}

func main() {

	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var target int
	fmt.Fscan(reader, &target)

	fmt.Fprintln(writer, calc(target))
}