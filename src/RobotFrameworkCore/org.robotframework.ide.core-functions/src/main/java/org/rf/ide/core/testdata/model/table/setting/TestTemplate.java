/*
 * Copyright 2015 Nokia Solutions and Networks
 * Licensed under the Apache License, Version 2.0,
 * see license.txt file for details.
 */
package org.rf.ide.core.testdata.model.table.setting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.rf.ide.core.testdata.model.AModelElement;
import org.rf.ide.core.testdata.model.FilePosition;
import org.rf.ide.core.testdata.model.IDataDrivenSetting;
import org.rf.ide.core.testdata.model.ModelType;
import org.rf.ide.core.testdata.model.table.SettingTable;
import org.rf.ide.core.testdata.text.read.recognizer.RobotToken;
import org.rf.ide.core.testdata.text.read.recognizer.RobotTokenType;

public class TestTemplate extends AModelElement<SettingTable> implements IDataDrivenSetting {

    private final RobotToken declaration;

    private RobotToken keywordName;

    private final List<RobotToken> unexpectedTrashArguments = new ArrayList<>();

    private final List<RobotToken> comment = new ArrayList<>();

    public TestTemplate(final RobotToken declaration) {
        this.declaration = declaration;
    }

    @Override
    public boolean isPresent() {
        return (declaration != null);
    }

    @Override
    public RobotToken getDeclaration() {
        return declaration;
    }

    @Override
    public RobotToken getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(final RobotToken keywordName) {
        if (keywordName != null) {
            fixForTheType(keywordName, RobotTokenType.SETTING_TEST_TEMPLATE_KEYWORD_NAME);
        }
        this.keywordName = keywordName;
    }

    @Override
    public List<RobotToken> getUnexpectedTrashArguments() {
        return Collections.unmodifiableList(unexpectedTrashArguments);
    }

    public void addUnexpectedTrashArgument(final RobotToken trashArgument) {
        if (trashArgument != null) {
            fixForTheType(trashArgument, RobotTokenType.SETTING_TEST_TEMPLATE_KEYWORD_UNWANTED_ARGUMENT);
        }
        this.unexpectedTrashArguments.add(trashArgument);
    }

    @Override
    public List<RobotToken> getComment() {
        return comment;
    }

    public void addCommentPart(final RobotToken rt) {
        fixComment(getComment(), rt);
        this.comment.add(rt);
    }

    @Override
    public ModelType getModelType() {
        return ModelType.SUITE_TEST_TEMPLATE;
    }

    @Override
    public FilePosition getBeginPosition() {
        return getDeclaration().getFilePosition();
    }

    @Override
    public List<RobotToken> getElementTokens() {
        final List<RobotToken> tokens = new ArrayList<>();
        if (isPresent()) {
            tokens.add(getDeclaration());
            if (getKeywordName() != null) {
                tokens.add(getKeywordName());
            }
            tokens.addAll(getUnexpectedTrashArguments());
            tokens.addAll(getComment());
        }

        return tokens;
    }
}
