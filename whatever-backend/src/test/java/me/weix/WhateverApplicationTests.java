package me.weix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhateverApplicationTests {

	@Test
	public void contextLoads() {
	}

	public static void main(String[] args) {
		Long aaa = null;
		Long bbb = 1L;
		System.out.println(aaa.compareTo(bbb));
	}

}
