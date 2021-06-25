package com.ak.ds.dao.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ak.ds.dao.interfaces.IAGenericDao;
import com.ak.ds.dao.util.DirectoryControl;
import com.ak.ds.entities.AEntity;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AGenericDao<T extends AEntity> implements IAGenericDao<T> {
	
    private Class<T> clazz;

    public AGenericDao(Class<T> clazz) {
	this.clazz = clazz;
    }

    public Class<T> getGenericClass() {
	return this.clazz;
    }
    
	public T add(T entity){		
		Long id = getId();
		entity.setId(id);
		writeOrRewriteInRepository(entity);
		return entity;
	}
	
	public T get(Long id){
		File file = getFile(id);
		ObjectMapper mapper = new ObjectMapper();
		T entity = null;
		try {
			entity = mapper.readValue(file, clazz);
		} catch (IOException e) {
			System.out.println("Something goes wrong");;
		}
		return entity;
	}

	public List<T> getAll(){
		ObjectMapper mapper = new ObjectMapper();
		List<T>  listEntities = new ArrayList<>();
		try {
			listEntities = Files.walk(Paths.get(getDirectoryPath()))
					.filter(p->!p.getFileName().equals(Paths.get("autoincrement")))
					.filter(Files::isRegularFile)
					.map(p -> {
						T entity = null;
						try {
							entity = mapper.readValue(p.toFile(), clazz);
						} catch (IOException e) {
							e.printStackTrace();
						}
						return entity;
						})
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listEntities;
	}

	public void remove(Long id) {
		File file = getFile(id);
		file.delete();
	}

	public void update(T entity){
		writeOrRewriteInRepository(entity);
	}

    private String getDirectoryPath() {
    return DirectoryControl.getPath(clazz.getSimpleName());
    }
    
    private File getFile(Long id) {
		return new File(getDirectoryPath() + id.toString() + ".json");
    }

	private void writeOrRewriteInRepository(T entity){
		File file = getFile(entity.getId());
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(file, entity);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Long getId() {
		String filePath = getDirectoryPath() + "autoincrement";
		BufferedWriter bufferedWriter = null;
		Long autoincrement = null;
		try {
			autoincrement = getAutoincrement(filePath) + 1;
			bufferedWriter = Files.newBufferedWriter(Paths.get(filePath), Charset.forName("UTF-8"));
			bufferedWriter.write(autoincrement.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return autoincrement;
	}

	private Long getAutoincrement(String filePath) throws IOException {
		File file = new File(filePath);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		Long autoincrement = Long.valueOf(bufferedReader.readLine());
		bufferedReader.close();
		fileReader.close();
		return autoincrement;
	}

}
