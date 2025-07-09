package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var size int
	fmt.Fscan(reader, &size)
	nums := make([]int, size)

	for i := 0; i < size; i++ {
		fmt.Fscan(reader, &nums[i])
	}

	sort.Ints(nums)

	for _, num := range nums {
		fmt.Fprintln(writer, num)
	}
}
