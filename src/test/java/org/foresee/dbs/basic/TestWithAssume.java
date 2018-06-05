package org.foresee.dbs.basic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.io.File;

public class TestWithAssume {
	@Test
	public void filenameIncludesUsername(){
		// 在Windows上，这个Assume会失败，所以将ignore这个测试（Runner的默认行为，自定义的Runner可能不同），
		// 显示结果是1 skipped		
		assumeThat(File.separatorChar, is('/'));
		assertThat(File.pathSeparator, is("/"));
	}
	@Test
	public void filenameIncludesUsername2(){
		assumeThat(File.separatorChar, is('\\'));
		assertThat(File.pathSeparator, is(not("/")));
	}
}
