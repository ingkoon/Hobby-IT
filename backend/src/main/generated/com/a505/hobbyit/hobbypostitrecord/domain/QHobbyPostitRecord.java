package com.a505.hobbyit.hobbypostitrecord.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHobbyPostitRecord is a Querydsl query type for HobbyPostitRecord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHobbyPostitRecord extends EntityPathBase<HobbyPostitRecord> {

    private static final long serialVersionUID = -1800312547L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHobbyPostitRecord hobbyPostitRecord = new QHobbyPostitRecord("hobbyPostitRecord");

    public final NumberPath<Integer> day = createNumber("day", Integer.class);

    public final com.a505.hobbyit.hobby.domain.QHobby hobby;

    public final NumberPath<Integer> month = createNumber("month", Integer.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QHobbyPostitRecord(String variable) {
        this(HobbyPostitRecord.class, forVariable(variable), INITS);
    }

    public QHobbyPostitRecord(Path<? extends HobbyPostitRecord> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHobbyPostitRecord(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHobbyPostitRecord(PathMetadata metadata, PathInits inits) {
        this(HobbyPostitRecord.class, metadata, inits);
    }

    public QHobbyPostitRecord(Class<? extends HobbyPostitRecord> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hobby = inits.isInitialized("hobby") ? new com.a505.hobbyit.hobby.domain.QHobby(forProperty("hobby")) : null;
    }

}

