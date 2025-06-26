package main

import (
	"bufio"
	"fmt"
	"os"
)

func multi(a, b int) int {
	return a * b
}

func main() {
	var reader *bufio.Reader = bufio.NewReader(os.Stdin)
	var writer *bufio.Writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	var a, b int

	fmt.Fscanln(reader, &a, &b)
	fmt.Fprintln(writer, multi(a, b))
}
