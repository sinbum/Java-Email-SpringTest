package testURL;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import test.URLTestController;

public class URLTest {

	MockMvc mock;
	
	@Before
	public void setup() {
		//MockMvc 객체를 생성하는 부분
		//null자리는 무엇이 오는가? 테스트할 컨트롤러 객체
		//mock = MockMvcBuilders.standaloneSetup(null).build();
		mock = MockMvcBuilders.standaloneSetup(new URLTestController()).build();
	}
	
	@Test
	public void urlTest() throws Exception {
		mock.perform(get("/hello").accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/html;charset=UTF-8"))
		.andExpect(content().string("hi world"));
		
	}
}
